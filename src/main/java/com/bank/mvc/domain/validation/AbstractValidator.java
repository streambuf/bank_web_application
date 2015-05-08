package com.bank.mvc.domain.validation;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Zalman on 08.05.2015.
 */
public class AbstractValidator {

    final static Logger logger = Logger.getLogger(AbstractValidator.class);

    protected void checkAllFieldsOnEmpty(Object obj, Map<String, String> errors) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.get(obj) == null || f.get(obj).toString() == "" || (Integer) f.get(obj) == 0) {
                    errors.put(f.getName(), "Необходимо заполнить поле");
                }
            } catch (IllegalAccessException | ClassCastException e) {

            }
        }

    }

}
