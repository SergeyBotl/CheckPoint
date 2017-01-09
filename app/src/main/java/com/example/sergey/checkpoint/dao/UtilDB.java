package com.example.sergey.checkpoint.dao;

import android.content.Context;
import android.widget.Toast;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UtilDB {

private Context context;

    public UtilDB(Context context) {
        this.context = context;
    }

    public String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream = context.openFileInput(fileName);
            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringTokenizer st;
                line = br.readLine();
                while (line != null) {
                    st = new StringTokenizer(line, " ");
                    while (st.hasMoreTokens()) {
                        sb.append(st.nextToken());
                        sb.append(" ");
                    }
                    sb.append("\n");
                    line = br.readLine();
                }
                inputStream.close();

            }

        } catch (IOException e) {
            Toast.makeText(context,
                    "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        return sb.toString();
    }


//----------------------------------------------------------------------

    public void writeFile(String fileName,String fileData) {

        try {
            OutputStream outputStream = context.openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);

            osw.write(fileData);
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(context,
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

    }
//================================================================================


    private static File path = new File("Result");
    private static List<?> emp = new ArrayList<>();



   /* public static void createFile() {
        writeToFile(file, createData.getDataEmployees());
        System.out.println("create file");
    }*/

    public static void writeToFile( List<?> emp) {
        try  {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(emp);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<?> readFromFile(File path) {
        try  {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            //emp = (List<Employees>) ois.readObject();
            return (List<?>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Wrong file");

        }
        return null;
    }

}




