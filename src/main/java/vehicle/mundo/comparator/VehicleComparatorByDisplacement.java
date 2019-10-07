package vehicle.mundo.comparator;

import vehicle.mundo.Vehiculo;

import java.util.Comparator;

public class VehicleComparatorByDisplacement implements Comparator< Vehiculo >
{
    @Override
    public int compare( Vehiculo o1, Vehiculo o2 )
    {
        return Integer.compare( o1.getDisplacement( ), o2.getDisplacement( ) );
    }
}
