package springproject.restuser.models.entity;import lombok.AllArgsConstructor;import lombok.Builder;import lombok.Data;import lombok.NoArgsConstructor;import javax.persistence.*;@Entity@Table(name = "users")@Data@NoArgsConstructor@AllArgsConstructor@Builderpublic class User {    private String username;    private String password;    private String name;    private String status;}