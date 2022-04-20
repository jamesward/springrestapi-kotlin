# Spring REST Kotlin

Based on:
https://seroter.com/2022/04/18/measuring-container-size-and-startup-latency-for-serverless-apps-written-in-c-node-js-go-and-java/

Run on JVM:
```
./gradlew bootRun
```

Containerize:
```
./gradlew bootBuildImage
```

Run on Docker:
```
docker run -p8080:8080 springrestapi-kotlin
```

### GCP

```
export PROJECT_ID=YOUR_PROJECT_ID

./gradlew bootBuildImage --imageName=gcr.io/$PROJECT_ID/springrestapi-kotlin

docker push gcr.io/$PROJECT_ID/springrestapi-kotlin

gcloud run deploy \
  --image=gcr.io/$PROJECT_ID/springrestapi-kotlin \
  --platform=managed \
  --allow-unauthenticated \
  --project=$PROJECT_ID \
  --region=us-central1 \
  springrestapi-kotlin
```