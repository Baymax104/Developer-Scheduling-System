package indi.Jake.team.service;

/**
 * @ClassName TeamException
 * @Description
 * @Author Jake
 * @Date 2021/1/27 17:42
 * @Version
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993110489948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
