package com.semillero.agendatatan.Databases;

/*
public class DbUsuarios extends DbHelper{



    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public long insertarUsuarios ( String nombre, String telefono, String Correo_Electronico, String contrasena){
        long id =0;

        // Metodo
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(nombreUsuario, nombre );
            values.put(telefonoUsuario, telefono);
            values.put(contrasenaUsuario, contrasena);
            values.put(Correo_ElectronicoUsuario, Correo_Electronico);

            id = db.insert(TABLE_USUARIOS, null, values);

        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }

}


     */
