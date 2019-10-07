package vehicle.mundo.comparator;

import vehicle.mundo.Vehiculo;

import java.util.Comparator;

public class VehicleComparatorByTrademark implements Comparator< Vehiculo >
{
    @Override
    public int compare( Vehiculo o1, Vehiculo o2 )
    {
        return o1.getTrademark( ).toLowerCase( ).compareTo( o2.getTrademark( ).toLowerCase( ) );
    }
}
