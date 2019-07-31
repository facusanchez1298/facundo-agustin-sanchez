package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

  private ArrayList<Files> allFiles;
  private ArrayList<Files> recentFiles;
  private Scanner scan;

  public Controller(){
    this.allFiles = new ArrayList<Files>();
    this.recentFiles = new ArrayList<Files>();
    this.scan = new Scanner(System.in);
  }

  public void addFile(Files file){
    allFiles.add(file);
  }

  public void addToRecent(Files files){

    if(this.recentFiles.contains(files))
      this.recentFiles.remove(files);

    else if(this.recentFiles.size() >= 15)
      this.recentFiles.remove(0);

    this.recentFiles.add(files);
  }

  public void showTheHome(){
    System.out.println("wellcome to your home, what do you want do?\n1 - see the recent files\n2 - see all the files\n3 - close");

    askWhatShow();
  }

  private void showFiles(ArrayList<Files> list, boolean isRecentFiles) {
    if (!list.isEmpty()) {
      System.out.println("what file want you open?");
      showFile(list, isRecentFiles);
      int numberEntered;
      boolean keepAsking = true;
      while(keepAsking) {
        numberEntered = scan.nextInt() - 1; //numero ingresado
        if (check(list, numberEntered)) {
          System.out.println(list.get(numberEntered).getContent());
          keepAsking = false;
          addToRecent(list.get(numberEntered));
        }
        else System.out.println("your number  is not valid, try again");
      }
    }else System.out.println("you don't have recent files");
    waitForKey();
    showTheHome();
  }

  private void showFile(ArrayList<Files> list, boolean isRecentFiles){
    if(isRecentFiles){
      for (int j = list.size() - 1; j >= 0; j--) {
        System.out.println((j + 1) + " " + list.get(j).getName());
      }
    }else {
      for (int i = 0; i < list.size(); i++) {
        System.out.println((i + 1) + " " + list.get(i).getName());
      }
    }
  }

  private void askWhatShow(){

    boolean keepAsking = true;
    while (keepAsking) {
      switch (scan.next().charAt(0)) {
        case '1':
          showFiles(recentFiles, true);
          keepAsking = false;
          break;
        case '2':
          showFiles(allFiles, false);
          keepAsking = false;
          break;
        case '3':
          System.exit(0);
        default:
          System.out.println("your number it's not correct. try again");
      }
    }
  }

  private void waitForKey() {
    System.out.println("touch enter for continue...");
    scan.nextLine();
  }

  private boolean check(ArrayList<Files> list, int i) {
    return list.size() >= i;
  }

}
