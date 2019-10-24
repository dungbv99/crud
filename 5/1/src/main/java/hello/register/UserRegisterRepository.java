package hello.register;

import org.springframework.data.repository.CrudRepository;

public interface UserRegisterRepository extends CrudRepository<UserRegister, Integer> {
}
