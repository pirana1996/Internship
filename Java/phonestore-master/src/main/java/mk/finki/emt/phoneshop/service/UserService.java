package mk.finki.emt.phoneshop.service;

import mk.finki.emt.phoneshop.model.User;

public interface UserService extends BaseEntityService<User> {
    User findByUsername(String username);
}
