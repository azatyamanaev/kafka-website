package ru.kfu.kafkaWebSite.utils;

import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

public class HibernateUtils {

    public static Class<?> getClassForHibernateObject(final Object object) {
        if (object instanceof HibernateProxy) {
            final LazyInitializer lazyInitializer = ((HibernateProxy) object).getHibernateLazyInitializer();
            return lazyInitializer.getPersistentClass();
        } else {
            return object.getClass();
        }
    }

    public static boolean isEqualHibernateObjectClasses(final Object object1, final Object object2) {
        return getClassForHibernateObject(object1) == getClassForHibernateObject(object2);
    }
}
