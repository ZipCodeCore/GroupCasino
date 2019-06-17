import exceptions.NegativeBetException;

public interface Gambling {
    Integer bet(Integer numOfChipsToBet) throws NegativeBetException;
}
