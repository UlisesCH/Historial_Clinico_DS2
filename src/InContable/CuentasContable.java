/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InContable;

/**
 *
 * @author ulise
 */
public class CuentasContable {
    
    //Listado de las cuentas y tipos de cuentas por grupo
    public static String ListaTipoCuentaAP[] = {"Corriente", "No Corriente"};
    public static String ListaTipoCuentaIG[] = {"Operativos", "No Operativos"};
    
    public static String ListaGrupoActivoCorriente[] 
    = {"EFECTIVO EN CAJA Y BANCOS", "INVERSIONES TEMPORALES", "CUENTAS Y DOCUMENTOS POR COBRAR",
       "ARRENDAMIENTOS FINANCIEROS POR COBRAR", "INVENTARIOS", "PAGOS ANTICIPADOS", 
       "DEPOSITOS EN GARANTIA"};
    
    public static String ListaGrupoActivoNoCorriente[] 
    = {"PROPIEDAD, PLANTA Y EQUIPO", "PROPIEDADES DE INVERSION", "ACTIVOS INTANGIBLES", 
       "INVERSIONES PERMANENTES", "DEPOSITOS EN GARANTIA", "CUENTAS Y DOCUMENTOS POR COBRAR A LARGO PLAZO",
       "ARRENDAMIENTOS FINANCIEROS POR COBRAR A LARGO PLAZO",
       "ESTIMACION PARA CUENTAS INCOBRABLES A LARGO PLAZO",
       "CONSTRUCCIONES EN PROCESO", "ACTIVO POR IMPUESTO SOBRE LA RENTA DIFERIDO"};
    
    public static String ListaGrupoPasivoCorriente[] 
    = {"PRESTAMOS Y SOBREGIROS BANCARIOS", "PROVEEDORES", "CUENTAS Y DOCUMENTOS POR PAGAR",
       "ANTICIPOS POR LIQUIDAR", "RETENCIONES Y DESCUENTOS", "BENEFICIO A EMPLEADOS POR PAGAR",
       "IMPUESTO POR PAGAR", "OBLIGACIONES BAJO ARRENDAMIENTO FINANCIERO"};
    
    public static String ListaGrupoPasivoNoCorriente[] 
    = {"CUENTAS Y DOCUMENTOS POR PAGAR A LARGO PLAZO", "PRESTAMOS A LARGO PLAZO",
       "OBLIGACIONES BAJO ARRENDAMIENTO FINANCIERO A LARGO PLAZO",
       "PASIVO POR IMPUESTO SOBRE LA RENTA DIFERIDO", "ESTIMACION PARA OBLIGACIONES LABORALES"};
    
    public static String ListaGrupoCapital[] 
    = {"CAPITAL SOCIAL", "RESERVA LEGAL", "UTILIDADES ACUMULADAS", "PERDIDAS ACUMULADAS"};
    
    public static String ListaGrupoIngresoOperativos[] 
    = {"INGRESOS POR VENTAS", "REBAJAS Y DEVOLUCIONES SOBRE VENTAS", "INGRESOS POR SERVICIOS",
       "INGRESOS POR REVERSION DEL DETERIORO"};
    
    public static String ListaGrupoIngresoNoOperativos[] 
    = {"OTROS INGRESOS"};
    
    public static String ListaGrupoCosto[] 
    = {"COSTOS DE VENTA", "COSTOS DE COMPRAS"};
    
    public static String ListaGrupoGastoOperativos[] 
    = {"GASTOS DE VENTAS Y SERVICIOS", "GASTOS DE ADMINISTRACION", 
       "GASTOS POR DETERIORO", "GASTOS POR IMPUESTOS SOBRE RENTA"};
    
    public static String ListaGrupoGastoNoOperativos[] 
    = {"GASTOS FINANCIEROS", "OTROS GASTOS"};
    
    //VARIABLES DE VALORES ALMACENADOS EN LA BASE DE DATOS
    private int ID;
    private String GrupoCuenta;
    private String TipoCuenta;
    private String SubGrupoCuenta;
    private String NombreCuenta;

    public CuentasContable(){
        
    }

    public CuentasContable(int ID, String GrupoCuenta, String TipoCuenta, String SubGrupoCuenta, String NombreCuenta) {
        this.ID = ID;
        this.GrupoCuenta = GrupoCuenta;
        this.TipoCuenta = TipoCuenta;
        this.SubGrupoCuenta = SubGrupoCuenta;
        this.NombreCuenta = NombreCuenta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGrupoCuenta() {
        return GrupoCuenta;
    }

    public void setGrupoCuenta(String GrupoCuenta) {
        this.GrupoCuenta = GrupoCuenta;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public String getSubGrupoCuenta() {
        return SubGrupoCuenta;
    }

    public void setSubGrupoCuenta(String SubGrupoCuenta) {
        this.SubGrupoCuenta = SubGrupoCuenta;
    }

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

    
}
