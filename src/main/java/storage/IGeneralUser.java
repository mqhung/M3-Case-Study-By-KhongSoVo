package storage;

import java.util.List;

public interface IGeneralUser<T> {
List<T> showAllFriend();
T findFriendById(int id);
}
