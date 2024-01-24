package lk.mobitel.abcbank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements SuperEntity{
    @Id
    @Column(length = 20)
    private String nic;
    @Column(length = 100,nullable = false)
    private String name;
    @Column(length = 300,nullable = false)
    private String address;
    @Column(name = "mobile_no",length = 20,nullable = false)
    private String mobileNo;
}
