# SimpleWeatherApp

## _Introduction_
With the utilization of the OpenWeatherApi, this application provides the capability to acquire comprehensive weather data for various cities and countries of interest.

<br />

## _About_
**Weather Page:**

• User is able to see city name, current temperature, feels like, highest and lowest temperature in the first part of the screen.

• User is able to see humidity, wind, sea level and coordinates of the city in the middle section.

• Use is able to see current weather description in the last section of the screen.


**City Selection Page:**

• User ise able to see available cities in this tab.

• User is able to select specific city.

• Cities is stored in local storage as JSON file. You can download JSON file from this link: http://bulk.openweathermap.org/sample/city.list.json.gz

• User is able to search cities from search area.


**Splash Screen:**

The provided JSON file is quite large. To ensure uninterrupted and lag-free user experience while utilizing the application, all data is fetched from the JSON file at the splash page. Furthermore, this data is temporarily stored in RAM, and when the city selection tab is clicked, the data is fetched from RAM.

<br />

## _MVVM Architecture_
Following the SOLID principles, the application employs the MVVM software architecture. Within the application, there are three main folders: "data," "ui," and "util." The "data" folder contains the "di" (dependency injection) folder, which houses the Dagger Hilt structures and modules. The "model" folder stores the necessary models (data classes) for the application. The "remote" folder holds the services responsible for connecting to the API. The "repository" folder contains classes responsible for connecting to API services or retrieving locally stored data. Under the "ui" folder, the "activity" folder includes the activities within the application, while the "adapter" folder contains the adapters required for RecyclerView. The "fragment" folder stores the fragment classes, and the "viewmodel" folder holds the ViewModel classes.

<br />

## _Dependencies_
During the development of the application, several dependencies were utilized including DaggerHilt, Retrofit, ViewModel and LiveData, Lottie, JsonReader.

<br />

## _Screenshoots_
<img src="https://github-production-user-asset-6210df.s3.amazonaws.com/47759665/241586340-8c903f1f-9126-4ec5-aa64-00633136d5ea.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230528%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230528T204244Z&X-Amz-Expires=300&X-Amz-Signature=bb6b9e57abcf02bb877bd99b2e4136e499065cf964239a87dfa9af7556765d67&X-Amz-SignedHeaders=host&actor_id=47759665&key_id=0&repo_id=645071158" width="249" height="512"> <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/47759665/241586342-eea18258-e6f4-49b8-8253-285b80b9e9dd.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230528%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230528T204338Z&X-Amz-Expires=300&X-Amz-Signature=971a2a46517d5c8be4c8cfea523df4a9c3f7a60070e7c5990f1f3007d2b3da4f&X-Amz-SignedHeaders=host&actor_id=47759665&key_id=0&repo_id=645071158" width="249" height="512">

<img src="https://github-production-user-asset-6210df.s3.amazonaws.com/47759665/241586344-86e76f29-23f5-44c1-b76c-a99d3ba28d38.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230528%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230528T204446Z&X-Amz-Expires=300&X-Amz-Signature=d72d28c3f68405cb9b048e44924cc27c059965dff7aa470406b7bd888f546486&X-Amz-SignedHeaders=host&actor_id=47759665&key_id=0&repo_id=645071158" width="249" height="512"> <img src="https://github-production-user-asset-6210df.s3.amazonaws.com/47759665/241586345-c605c387-205f-4183-8b63-99404a9f547d.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230528%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230528T204520Z&X-Amz-Expires=300&X-Amz-Signature=c105c3aacf5c14c49e860896f4814584cee62773ab3cac69c79b4ecb927738f9&X-Amz-SignedHeaders=host&actor_id=47759665&key_id=0&repo_id=645071158" width="249" height="512">

<br />

**The codebase also includes KDoc, which is a documentation format specifically designed for Kotlin. Recomended Screen Sizes: 5" - 6.65"**


