package com.hamza.bitma.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.hamza.bitma.enumeration.ERole;
import com.hamza.bitma.security.model.SecurityProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final FirebaseAuth firebaseAuth;


    public void assignRole(List<ERole> requestRoles, String uid) throws FirebaseAuthException {
        try {
            List<String> roles = requestRoles
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.toList());

            Map<String, Object> claims = Map.of("custom_claims", roles);

            firebaseAuth.setCustomUserClaims(uid, claims);
        } catch (FirebaseAuthException e) {
            log.error("Firebase Auth Error ", e);
        }
    }
}
