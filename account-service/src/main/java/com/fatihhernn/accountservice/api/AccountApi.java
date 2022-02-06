package com.fatihhernn.accountservice.api;

import com.fatihhernn.accountservice.service.AccountService;
import com.fatihhernn.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }
    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id, @RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.update(id,accountDto));
    }
    @DeleteMapping("/delete")
    public void delete(String id){
        accountService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(accountService.findAll(pageable));
    }

}
