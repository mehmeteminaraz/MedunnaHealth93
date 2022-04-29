package pojos.US018_Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Physician {
    /*
    {
            "createdBy": "oscarlebsack",
            "createdDate": "2022-03-01T13:26:00.734890Z",
            "id": 10501,
            "firstName": "Arif",
            "lastName": "Canpol",
            "birthDate": "1991-01-31T23:00:00Z",
            "phone": "5354334312",
            "gender": "MALE",
            "bloodGroup": "Apositive",
            "adress": "",
            "description": "",
            "user": {
                "createdBy": "anonymousUser",
                "createdDate": "2022-03-01T13:19:47.400256Z",
                "id": 10097,
                "login": "arifcanpol135",
                "firstName": "Arif",
                "lastName": "Canpol",
                "email": "canpolska@gmail.co",
                "activated": true,
                "langKey": "en",
                "imageUrl": null,
                "resetDate": null,
                "ssn": "331-13-1131"
            },
            "speciality": "ALLERGY_IMMUNOLOGY",
            "country": null,
            "cstate": null,
            "examFee": 200.00,
            "image": "",
            "imageContentType": null
        },
     */


    private int examFee;
    private String firstName;
    private String phone;
    private String ssn;
    private User user;


}
