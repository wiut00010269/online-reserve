//package nurbek.onlinereserve.rest.external;
//
//// Abduraximov Nurbek  4/27/2024   6:45 PM
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//@RequiredArgsConstructor
//public class StorageService {
//
//    @Value("${application.bucket.name}")
//    private String bucketName;
//
//    private final AmazonS3 s3Client;
//
////    public String uploadFile(MultipartFile file) {
////        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
////        s3Client.putObject(new PutObjectRequest(bucketName, ))
////    }
//
//}
