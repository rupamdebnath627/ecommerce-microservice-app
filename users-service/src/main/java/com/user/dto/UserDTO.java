package com.user.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.user.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long userId;
	
	@Email(message = "Invalid Email: Doesn't follow email format")
	private String email;
	
	@Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
    @Max(value = 100, message = "Invalid Age: Exceeds 100 years")
	private Integer age;
	
	private Gender gender;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfJoining;
}
