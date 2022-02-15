package org.example.config.factory;

import org.example.model.BaseObjectModel;

public interface BaseServiceAction {
    Object save(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object update(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object batchUpdate(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryList(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryPage(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryDetail(BaseObjectModel baseObjectModel) throws IllegalAccessException;
}
