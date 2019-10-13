package vehicle.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2DB implements DataBase
{
    @Override
    public void connection( String url, String user, String password )
    {
        try
        {
            Connection connection = DriverManager.getConnection( url, user, password );
            Statement statement = connection.createStatement( );
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM VEHICLE" );

            while ( resultSet.next( ) )
            {
                System.out.printf( "%d %s %s %s %s %d %d %d %d, \n",
                                   resultSet.getInt( 1 ),
                                   resultSet.getString( 2 ),
                                   resultSet.getString( 3 ),
                                   resultSet.getString( 4 ),
                                   resultSet.getString( 5 ),
                                   resultSet.getInt( 6 ),
                                   resultSet.getInt( 7 ),
                                   resultSet.getInt( 8 ),
                                   resultSet.getInt( 9 ) );
            }
        }
        catch ( SQLException e )
        {
            Logger log = Logger.getLogger( H2DB.class.getName( ) );
            log.log( Level.SEVERE, e.getMessage( ), e );
        }
    }
}
