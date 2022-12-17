
package com.parcar.interfaces;

import java.util.List;

public interface CRUD {
    
    public List<Object> listar() throws Exception;
    
    public void registrar(Object obj) throws Exception;
    
    public void editar(Object obj) throws Exception;
    
    public void eliminar(Object obj) throws Exception;
    
    public Object obtenerObjecto(Object obj) throws Exception;
    
    public List<Object> listar(Object obj) throws Exception;
    
}
