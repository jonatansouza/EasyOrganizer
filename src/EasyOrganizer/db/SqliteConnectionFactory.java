/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package EasyOrganizer.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 
 * Fabrica de conexões fornece uma conexão com o sqlite através do drive dentro do diretório resource
 * 
 * IMPORTANTE
 * Caso ocorra algum erro na compilação verefique se o drivers dentro do diretorio driver estao no classpath
 * 
 * @author Ana Paula
 */
public class SqliteConnectionFactory {
    /**
     * Cria uma conexão
     * @return Caso ocorra algum erro verifique se os jars dentro do folder driver estão no classpath
     */
    public static Connection connect() {
        Connection c = null;
        File resource = new File("resource");
        if(!resource.isDirectory()){
            System.out.println("Creating dir");
            resource.mkdir();
        }
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resource/easyorganizer.db");
            return c;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return null;
    }
    
    
}   
