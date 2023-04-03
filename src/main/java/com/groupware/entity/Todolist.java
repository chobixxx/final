package team3.groupware5.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter


@Entity
public class Todolist {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int num;//pk주기위해서 
   
   @NonNull
   private String title;//제목
   @NonNull
   private String content;//내용
   @NonNull
   private int importance;//중요도
   @NonNull
   private String date;//날짜
   @NonNull
   private String time;//시간
   @ManyToOne
   @NonNull
   @JoinColumn(name="employeeNo")
   private Employee employeeNo;
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Todolist [num=");
	builder.append(num);
	builder.append(", employeeNo=");
	builder.append(employeeNo.getEmployeeNo());
	builder.append(", title=");
	builder.append(title);
	builder.append(", content=");
	builder.append(content);
	builder.append(", importance=");
	builder.append(importance);
	builder.append(", date=");
	builder.append(date);
	builder.append(", time=");
	builder.append(time);
	builder.append("]");
	return builder.toString();
}

   
   

}