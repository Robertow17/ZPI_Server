package com.zpi.account;

import com.zpi.service.ServiceDTO;
import com.zpi.service.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController
{
    @Autowired
    private AccountService accountService;


    @GetMapping("/get/{login}")
    public ResponseEntity<List<ServiceDTO>> findAllServicesByUser( @PathVariable(value = "login") String login)
    {
        return ResponseEntity.ok(ServiceMapper.INSTANCE.toServiceDTOs(accountService.findAllServicesByUser(login)));
    }


    @PostMapping(("/add"))
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO accountDTO)
    {
        accountService.save(AccountMapper.INSTANCE.toAccount(accountDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<AccountDTO>> getAll()
    {
        return ResponseEntity.ok(AccountMapper.INSTANCE.toAccountDTOs(accountService.findAll()));
    }

    @GetMapping("/{id}/{login}")
    public ResponseEntity<AccountDTO> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {
        Optional<Account> account = accountService.findById(idService, login);

        if(!account.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(AccountMapper.INSTANCE.toAccountDTO(account.get()));
    }

    @PutMapping("/update/{id}/{login}")
    public ResponseEntity<AccountDTO> update(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login, @Valid @RequestBody AccountDTO accountDTO)
    {
        Account account = AccountMapper.INSTANCE.toAccount(accountDTO);
        account.setPk(new AccountPK(idService, login));
        accountService.save(account);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountDTO);
    }

    @DeleteMapping("/delete/{id}/{login}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {
        accountService.deleteById(idService, login);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
