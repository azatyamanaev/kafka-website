function sendAnswers() {
    const formData = new FormData(document.querySelector("form"));
    let response = { answers: [] }
    for (const pair of formData.entries()){
        if ( !pair[0].startsWith("question") ) {
            response[pair[0]] = pair[1]
        } else {
            let enterable = $("input[name='" + pair[0] + "']")
            if ( enterable.hasClass("input-text") ) {
                response["answers"].push({id: Number(enterable.attr("id")), text: pair[1]})
            } else {
                response["answers"].push({id: Number(pair[1])})
            }
        }
    }
    $.ajax({
        url: location.protocol + '//' + location.host + "/end-survey",
        type: "POST",
        data: JSON.stringify(response),
        contentType: "application/json"
    })
        .done(function () {
            window.location.replace("/pass-survey");
        })
        .fail(function () {
            window.location.replace("/pass-survey");
        });
}

function sendQuestions() {
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
                    response["questions"].push({id: questionNumber, answers: [{id: Number(enterable.attr("id")), text: pair[1]}]})
                } else {
                    response["questions"].at(qi)["answers"].push({id: Number(enterable.attr("id")), text: pair[1]})
                }
            } else {
                if ( qi < 0 ) {
                    response["questions"].push({id: questionNumber, answers: [{id: Number(pair[1])}]})
                } else {
                    response["questions"].at(qi)["answers"].push({id: Number(pair[1])})
                }
            }
        }
    }
    $.ajax({
        url: location.protocol + '//' + location.host + "/end-survey",
        type: "POST",
        data: JSON.stringify(response),
        contentType: "application/json"
    })
        .done(function () {
            window.location.replace("/pass-survey");
        })
        .fail(function () {
            window.location.replace("/pass-survey");
        });
}