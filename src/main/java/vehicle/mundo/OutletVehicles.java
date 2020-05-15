package vehicle.mundo;

import java.util.ArrayList;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los vehiculos.
 */
public final class OutletVehicles extends ArrayList<Vehicle>
{
    /**
     * Organiza la lista de vehiculos por marca usando a Comparator. <br>
     *
     * @postcondition La lista de vehiculos est ordenada por marca
     */
    public void sortByTrademark()
    {
        sort(Vehicle::compareTrademark);
    }

    /**
     * Organiza la lista de vehiculos por cilindrada usando a Comparator. <br>
     * @postcondition La lista de vehiculos est ordenada por cilindrada
     */
    public void sortForDisplacement( )
    {
        sort(Vehicle::compareDisplacement);
    }

    /**
     * Organiza la lista de vehiculos por el ao usando a Comparator. <br>
     * @postcondition La lista de vehiculos est ordenada por ao
     */
    public void sortForYear( )
    {
        sort(Vehicle::compareYear);
    }

    /**
     * Busca un vehiculo segn su modelo y retorna la posicin en la que se encuentra. <br>
     * @param modelo El modelo del vehiculo buscado - modelo != null
     * @param anio El ao del vehiculo buscado - anio > 0
     * @return Retorna la posicin donde se encuentra un vehiculo con el modelo y el ao dado. Si no se encuentra ningn vehiculo con ese modelo y ao retorna -1.
     */
    public int buscarVehiculo( String modelo, int anio)
    {
        int posicion = -1;
        boolean termine = false;

        for (int i = 0; i < size() && !termine; i++) {
            Vehicle vehiclePosicion = get(i);
            String modeloVehiculo = vehiclePosicion.getModelo();

            // Los modelos son iguales
            if (modeloVehiculo.equals(modelo) && vehiclePosicion.getYear() == anio) {
                posicion = i;
                termine = true;
            }
        }

        return posicion;
    }

    /**
     * Agrega un nuevo vehiculo
     * @param modeloV El modelo del vehiculo - modeloV != null
     * @param marcaV La marca del vehiculo - marcaV != null
     * @param imagenP La ruta a la imagen del vehiculo - imagenP != null
     * @param tipoV El tipo de vehiculo - tipoV es uno de {BUS, AUTMOVIL, MOTOCICLETA, CAMION}
     * @param anioV El ao del vehiculo - anioV > 0
     * @param cilindradaV La cilindrada del vehiculo - cilindradaV > 0
     * @param ejesV El nmero de ejes del vehiculo - ejesV > 0
     * @param valor El valor del vehiculo - valor > 0
     * @return Se retorn true si el vehiculo fue agregado o false en caso de que ya existiera un vehiculo con el mismo modelo y ao
     */
    public boolean agregarVehiculo( String modeloV, String marcaV, String imagenP, String tipoV, int anioV, int cilindradaV, int ejesV, int valor )
    {
        boolean agregado = false;
        int vehiculoBuscado = buscarVehiculo( modeloV, anioV );
        if( vehiculoBuscado == -1 ) {
            Vehicle nuevovehiculo = new Vehicle(modeloV, marcaV, imagenP, tipoV, anioV, cilindradaV, ejesV, valor);
            add(nuevovehiculo);
            agregado = true;
        }

        return agregado;

    }

    /**
     * Elimina de la lista el vehiculo especificado
     * @param modelo Modelo del vehiculo - modelo!=null
     * @param anio Ao del vehiculo - anio>0
     * @return Se retorn true si el vehiculo fue comprado o false en caso contrario
     */
    public boolean comprarVehiculo( String modelo, int anio)
    {
        boolean comprado = false;

        for (int cont = 0; cont < size() && !comprado; cont++) {
            Vehicle v = get(cont);

            if (v.getYear() == anio && v.getModelo().equalsIgnoreCase(modelo)) {
                remove(cont);
                comprado = true;
            }
        }

        return comprado;
    }

    /**
     * Busca el vehiculo mas antiguo de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas antiguo. Si no hay vehiculos a la venta se retorn -1
     */
    public int buscarVehiculoMasAntiguo( )
    {
        sort(Vehicle::compareYear);

        // The first element of list always is the more old.
        return 0;
    }

    /**
     * Busca el vehiculo mas econmico de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas econmico. Si no hay vehiculos a la venta se retorn -1
     */
    public int getIndexOfVehicleMoreCheap( )
    {
        sort(Vehicle::compareValue);

        // Return 0, because the first element of the list is the more cheap.
        return 0;
    }

    /**
     * Busca el vehiculo mas potente (con mayor cilindrada) de todos
     * @return Se retorn la posicin donde se encuentra el vehiculo mas nuevo. Si no hay vehiculos a la venta se retorn -1
     */
    public int getIndexOfVehicleMorePowerful( )
    {
        sort(Vehicle::compareDisplacement);

        // The last element always is more powerful
        return size() - 1;
    }

    /**
     * Disminuye en un 10% el precio de todos los vehiculos cuyo precio es mayor al valor especificado. <br>
     * El precio de un vehiculo slo se disminuye si su valor no queda en cero.
     * @param valor El valor para realizar la disminucin de precios. valor>0
     * @return La cantidad de vehiculos a los que se les disminuy el precio
     */
    public int disminuirPrecio( int valor )
    {
        int disminuidos = 0;

        for (Vehicle v : this) {
            if (v.getValue() > valor) {
                int nValor = (int)(v.getValue() * 0.9);

                if (nValor > 0) {
                    v.setValue(nValor);
                    disminuidos++;
                }
            }
        }

        return disminuidos;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensin
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensin 1
     * @return respuesta 1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Ejecuta el punto de extensin 2
     * @return respuesta 2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }
}