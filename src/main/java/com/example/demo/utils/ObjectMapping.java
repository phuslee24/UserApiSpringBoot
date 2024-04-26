package com.example.demo.utils;

import java.lang.reflect.Field;

public class ObjectMapping<M, O> {

	/**
	 * Parse model to object
	 *
	 * @param mo
	 * @param obj
	 * @return
	 */
	public O parseToObj(M mo, O obj) {
		try {
			Field[] modelFields = mo.getClass().getDeclaredFields();
			Field[] objFields = obj.getClass().getDeclaredFields();

			for (Field modelField : modelFields) {
				for (Field objField : objFields) {
					if (modelField.getName().equals(objField.getName()) && modelField.getType().equals(objField.getType())) {
						modelField.setAccessible(true);
						objField.setAccessible(true);
						Object value = modelField.get(mo);
						objField.set(obj, value);
						modelField.setAccessible(false);
						objField.setAccessible(false);
					}
				}
			}
			return obj;
		} catch (Exception e) {
			throw new RuntimeException("Error mapping entity to DTO", e);
		}
	}

	/**
	 * Maping object to model
	 *
	 * @param obj
	 * @param mo
	 * @return
	 */
	public M mapToModel(O obj, M mo) {
		try {
			Field[] modelFields = mo.getClass().getDeclaredFields();
			Field[] objFields = obj.getClass().getDeclaredFields();

			for (Field modelField : modelFields) {
				for (Field objField : objFields) {
					if (modelField.getName().equals(objField.getName()) && modelField.getType().equals(objField.getType())) {
						modelField.setAccessible(true);
						objField.setAccessible(true);
						Object value = objField.get(obj);
						modelField.set(mo, value);
						modelField.setAccessible(false);
						objField.setAccessible(false);
					}
				}
			}
			return mo;
		} catch (Exception e) {
			throw new RuntimeException("Error mapping DTO to entity", e);
		}
	}
}
