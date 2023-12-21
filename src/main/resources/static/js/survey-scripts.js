function sendSurveyResponseWithQuestions() {
    const formData = new FormData(document.querySelector("form"));
    let response = { questions: [] }
    for (const pair of formData.entries()){
        if ( !pair[0].startsWith("question") ) {
            response[pair[0]] = pair[1]
        } else {
            let questionNumber = Number(pair[0].replace("question", ''))
            let qi = response["questions"].findIndex((q) => questionNumber - q.id === 0)
            let enterable = $("input[name='" + pair[0] + "']")
            if ( enterable.hasClass("input-text") ) {
                if ( qi < 0 ) {
                    response["questions"].push({questionId: questionNumber, answers: [{answerOptionId: Number(enterable.attr("id")), text: pair[1]}]})
                } else {
                    response["questions"].at(qi)["answers"].push({answerOptionId: Number(enterable.attr("id")), text: pair[1]})
                }
            } else {
                if ( qi < 0 ) {
                    response["questions"].push({questionId: questionNumber, answers: [{answerOptionId: Number(pair[1])}]})
                } else {
                    response["questions"].at(qi)["answers"].push({answerOptionId: Number(pair[1])})
                }
            }
        }
    }
    $.ajax({
        url: location.protocol + '//' + location.host + "/surveys/" + formData.get("surveyId"),
        type: "POST",
        data: JSON.stringify(response),
        contentType: "application/json"
    })
        .done(function () {
            window.location.reload();
        })
        .fail(function () {
            window.location.reload();
        });
}

const newQuestionHtml =
    "<div class=\"card mt-3\" id=\"question-${qn}\">\n" +
    "  <div class=\"d-flex m-3\">\n" +
    "    <input type=\"text\" class=\"form-control input-text flex-fill\" placeholder=\"Текст вопроса\" name=\"question-${qn}\">\n" +
    "    <button onclick=\"removeQuestion(this)\" class=\"ml-3 btn btn-secondary\" id=\"question-${qn}_remove\">Убрать</button>\n" +
    "  </div>\n" +
    "  <hr class=\"card-split\">\n" +
    "\n" +
    "  <div class=\"mx-3 mt-3\">\n" +
    "    <div class=\"d-flex flex-row align-items-center\" data-toggle=\"buttons\">\n" +
    "      <label class=\"same-size m-0\">Тип ответа: </label>\n" +
    "          <div class=\"btn-group btn-group-toggle flex-fill\">\n" +
    "              <label class=\"btn btn-secondary active\" onclick=\"changeQuestionType(this)\" id=\"question-${qn}_type-radio\">\n" +
    "                  <input type=\"radio\" name=\"question-${qn}_type\" value=\"radio\" checked>Один вариант\n" +
    "              </label>\n" +
    "              <label class=\"btn btn-secondary flex-fill\" onclick=\"changeQuestionType(this)\" id=\"question-${qn}_type-multi\">\n" +
    "                  <input type=\"radio\" name=\"question-${qn}_type\" value=\"multi\">Несколько вариантов\n" +
    "              </label>\n" +
    "              <label class=\"btn btn-secondary flex-fill\" onclick=\"changeQuestionType(this)\" id=\"question-${qn}_type-input\">\n" +
    "                  <input type=\"radio\" name=\"question-${qn}_type\" value=\"input\">Текстовый ввод\n" +
    "              </label>\n" +
    "          </div>\n" +
    "      </div>\n" +
    "  </div>\n" +
    "\n" +
    "  <div id=\"question-${qn}_answers\" class=\"mx-3 mb-3 mt-0\">\n" +
    "      <input type=\"text\" onfocus=\"newAnswerText(this)\" tabindex=\"-1\" id=\"question-${qn}_new-answer\" class=\"form-control input-text flex-fill mt-3 new-element\" placeholder=\"Текст варианта\">\n" +
    "  </div>\n" +
    "</div>"
const newAnswerOption =
    "<div class=\"d-flex mt-3\" id=\"${qn}_answer-${an}\">\n" +
    "    <input type=\"text\" class=\"form-control input-text flex-fill\" placeholder=\"Текст варианта\" name=\"${qn}_answer-${an}\">\n" +
    "    <button onclick=\"removeAnswer(this)\" class=\"ml-3 btn btn-secondary\" id=\"${qn}_answer-${an}_remove\">Убрать</button>\n" +
    "</div>"
const newAnswersWithOptions =
    "  <div id=\"${qn}_answers\" class=\"mx-3 mb-3 mt-0\">\n" +
    "      <input type=\"text\" onfocus=\"newAnswerText(this)\" tabindex=\"-1\" id=\"${qn}_new-answer\" class=\"form-control input-text flex-fill mt-3 new-element\" placeholder=\"Текст варианта\">\n" +
    "  </div>"
const newAnswersWithInput =
    "  <div id=\"${qn}_answers\" class=\"m-3\">\n" +
    "      <input type=\"text\" disabled class=\"form-control input-text flex-fill\" placeholder=\"Поле ввода ответа\">\n" +
    "      <input type=\"hidden\" value=\"\" name=\"${qn}_answer-1\">\n" +
    "  </div>"

let lastQuestionNumber = 0
let questionAnswerNumbers = new Map()
function newQuestion() {
    let newQuestion = $("#new-question")
    lastQuestionNumber++
    newQuestion.before(
        newQuestionHtml.replaceAll("${qn}", lastQuestionNumber)
    )
    $("input[name='question-" + lastQuestionNumber + "']").focus()
    questionAnswerNumbers.set("question-" + lastQuestionNumber, 0)
}

function removeQuestion(element) {
    let questionId = element.id.toString().replace('_remove','')
    $("#" + questionId).remove()
    questionAnswerNumbers.delete("question-" + lastQuestionNumber)
}

function newAnswerText(element) {
    let newAnswerOptionId = element.id.toString()
    let questionId = newAnswerOptionId.substring(0, newAnswerOptionId.indexOf('_'))
    questionAnswerNumbers.set(questionId, questionAnswerNumbers.get(questionId) + 1)
    $("#" + newAnswerOptionId).before(
        newAnswerOption.replaceAll("${qn}", questionId).replaceAll("${an}", questionAnswerNumbers.get(questionId))
    )
    $("input[name='" + questionId + "_answer-" + questionAnswerNumbers.get(questionId) + "']").focus()
}

function removeAnswer(element) {
    let answerId = element.id.toString().replace('_remove', '')
    $("#" + answerId).remove()
}

function changeQuestionType(element) {
    let questionTypeSelectorId = element.id.toString()
    let questionId = questionTypeSelectorId.substring(0, questionTypeSelectorId.indexOf('_'))
    let newAnswer = newAnswersWithOptions
    if (questionTypeSelectorId.endsWith("input")) {
        newAnswer = newAnswersWithInput
    }
    $("#" + questionId + "_answers").replaceWith(newAnswer.replaceAll("${qn}", questionId))
    questionAnswerNumbers.set(questionId, 0)
}

function sendSurvey() {
    const formData = new FormData(document.querySelector("form"));
    let response = {
        name: formData.get("name"),
        description: formData.get("description"),
        questions: []
    }

    let questionNums = []
    for (const key of formData.keys()) {
        if (key.match("question-\\d+$") !== null) {
            questionNums.push(Number(key.substring(key.indexOf('-') + 1)))
        }
    }
    questionNums.sort(function(a, b) {return a - b;})
    let n = 1
    for (const questionNum of questionNums) {
        let question = createQuestion(
            n,
            formData.get("question-" + questionNum.toString()),
            formData.get("question-" + questionNum.toString() + "_type").toUpperCase()
        )
        console.log("question-" + questionNum.toString() + "_type")
        for (const pair of formData.entries()) {
            if (pair[0].match("question-" + questionNum + "_answer-\\d+$") !== null) {
                question["answerOptions"].push(createAnswer(pair[1]))
            }
        }
        response["questions"].push(question)
        n++
    }

    $.ajax({
        url: location.protocol + '//' + location.host + "/create-survey",
        type: "POST",
        data: JSON.stringify(response),
        contentType: "application/json"
    })
        .done(function () {
            window.location.replace("/");
        })
        .fail(function () {
            window.location.replace("/create-survey");
        });
}

function createQuestion(number, text, type) {
    return {
        number: number,
        text: text,
        type: type,
        isRequired: false,
        isVerifiable: false,
        answerOptions: []
    }
}

function createAnswer(text) {
    return {
        text: text,
        isCorrect: false
    }
}

// function sendSurveyResponseWithAnswers() {
//     const formData = new FormData(document.querySelector("form"));
//     let response = { answers: [] }
//     for (const pair of formData.entries()){
//         if ( !pair[0].startsWith("question") ) {
//             response[pair[0]] = pair[1]
//         } else {
//             let enterable = $("input[name='" + pair[0] + "']")
//             if ( enterable.hasClass("input-text") ) {
//                 response["answers"].push({id: Number(enterable.attr("id")), text: pair[1]})
//             } else {
//                 response["answers"].push({id: Number(pair[1])})
//             }
//         }
//     }
//     $.ajax({
//         url: location.protocol + '//' + location.host + "/end-survey",
//         type: "POST",
//         data: JSON.stringify(response),
//         contentType: "application/json"
//     })
//         .done(function () {
//             window.location.replace("/pass-survey");
//         })
//         .fail(function () {
//             window.location.replace("/pass-survey");
//         });
// }