package ThinkingInJava.InnerClasses.P290;

import java.util.*;
import java.io.*;

public class Controller {
    private List<Event> eventList = new LinkedList<>();

    public void addEvent(Event c){ eventList.add(c); }
    public void addEvent(File file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] config;
                if((config = line.split("\\s+")).length == 2) {
                Event event = EventFactory.eventFactoryMap.get(config[0]).createEvent(Integer.parseInt(config[1]));
                eventList.add(event);
                }
                else System.out.println("Error in the line " + config[0] + " " + config[1]);
            }
        } catch (FileNotFoundException e) {
            System.err.println(file.getName() + " not found " + e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public List<Event> getEventList() {
        return eventList;
    }
    public void run(){
        while(eventList.size() > 0)
            for (Event e: new LinkedList<>(eventList))
                if (e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
        }
    }

