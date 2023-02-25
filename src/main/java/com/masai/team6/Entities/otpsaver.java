package com.masai.team6.Entities;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class otpsaver {
	
//	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
	@Id
	private String email;
	
	
	private int otp;
	
//	@JsonFormat(pattern="dd/MM/yyyy HH:MM")
	@Column(name = "otp_requested_time")
    private LocalDateTime otpRequestedTime;
     
         
	
}
