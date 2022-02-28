package org.example.config.factory;

import org.example.common.BaseObjectModel;

public interface BaseServiceAction {
    Object save(BaseObjectModel baseObjectModel) throws Exception;
    Object update(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object batchSave(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object batchUpdate(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryList(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryPage(BaseObjectModel baseObjectModel) throws IllegalAccessException;
    Object queryDetail(BaseObjectModel baseObjectModel) throws IllegalAccessException;
}
