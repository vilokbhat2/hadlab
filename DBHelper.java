import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbName="studentdb"; // Database Name
    private static final String tbName="student" ; // Table Name
    private static final int dbVersion = 1 ;
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tbName+"(uname VARCHAR(10) ,passw VARCHAR(10))"+";");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+tbName);
        onCreate(db);
    }
    public long adduser(String name,String pass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("uname",name);
        cv.put("passw ",pass);
        long result = db.insert(tbName, null,cv);
        db.close();
        return result ;
    }
    public void update(String name, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+tbName+" SET passw='"+pass+"'"+" WHERE uname='"+name+"';");//6(b)
        // UPDATE tbName SET passw='pass' WHERE uname='name' ; SQL statement
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+tbName+" WHERE uname='" +name+"';");
        db.close();
    }
    public String display(Context ctx){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tbName, null);
        String finalres = " " ;
        while(cursor.moveToNext()){
            finalres += cursor.getString(0)+":"+cursor.getString(1);
        }
        return finalres;
    }
}
