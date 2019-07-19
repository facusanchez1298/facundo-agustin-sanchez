package ejercicio1;

public class Main {

  public static void main(String[] args) {

    Files sometime = new Files("sometime", "Sometime i write beautifull things. this is not one");
    Files happyLife = new Files("happy life", "The life could be happy... and not");
    Files aLittlePeace = new Files("A little peace", "every body had a little peace of heaven in the worl");
    Files iDontKnow = new Files("I don't know", "may the life is only a videogame and i'm playing");
    Files whereIs = new Files( "Where is", "I've think: where is the time when we need him?");
    Files happier = new Files("Happier", "i don't remember the lyric of this song");
    Files afroid = new Files("Afroid","why you are soo afraid to lose? what you are thinking that will happen if you do?");
    Files writing = new Files("Writing", "i don't know what write now");
    Files aLotOfBooks = new Files("A lot of books", "i think in a lot of books");
    Files emptyFile = new Files("Empty name", "Empty text to");
    Files thiking = new Files("My think", "May 3 books on the recent files wold be better");
    Files music = new Files("music is beauti", "i make music sometimes");
    Files thing = new Files("a thing", "whatever");
    Files otherThing = new Files("Other Thing", "whatever x 2");
    Files iDontKnowTheNumbers = new Files("i don't know the numbers", "i don't remember the numbers in inglis, i'll learning again");
    Files almostLast = new Files("this is not the end", "missing files yet");
    Files thelast = new Files("i don't will make other file", "i writed a lot of files");

    Controller controller = new Controller();
    controller.addFile(sometime);
    controller.addFile(happier);
    controller.addFile(happyLife);
    controller.addFile(aLittlePeace);
    controller.addFile(iDontKnowTheNumbers);
    controller.addFile(iDontKnow);
    controller.addFile(whereIs);
    controller.addFile(afroid);
    controller.addFile(writing);
    controller.addFile(aLotOfBooks);
    controller.addFile(emptyFile);
    controller.addFile(thiking);
    controller.addFile(music);
    controller.addFile(thing);
    controller.addFile(otherThing);
    controller.addFile(almostLast);
    controller.addFile(thelast);

    controller.showTheHome();


  }

}
