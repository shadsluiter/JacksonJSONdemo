package edu.gcu.shadsluiter.jsonfileio;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    Context context;

    ObjectMapper om = new ObjectMapper();


    public DataService(Context context) {
        this.context = context;
    }

    public void writeList(CarList carList, String filename) {


        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        try {

            om.writerWithDefaultPrettyPrinter().writeValue(file, carList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CarList readList(String filename) {
        File path = context.getExternalFilesDir(null);
        File file = new File(path, filename);
        CarList returnList = new CarList();

        try {
            returnList = om.readValue(file, CarList.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;


    }
}
