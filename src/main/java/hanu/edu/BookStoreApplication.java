package hanu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(@NotNull CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods(CorsConfiguration.ALL)
//                        .allowedHeaders(CorsConfiguration.ALL)
//                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
//            }
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/static/**")
//                        .addResourceLocations("/WEB-INF/view/react/build/static/");
//                registry.addResourceHandler("/*.js")
//                        .addResourceLocations("/WEB-INF/view/react/build/");
//                registry.addResourceHandler("/*.jsx")
//                        .addResourceLocations("/WEB-INF/view/react/build/");
//                registry.addResourceHandler("/*.json")
//                        .addResourceLocations("/WEB-INF/view/react/build/");
//                registry.addResourceHandler("/*.ico")
//                        .addResourceLocations("/WEB-INF/view/react/build/");
//                registry.addResourceHandler("/login")
//                        .addResourceLocations("/WEB-INF/view/react/build/index.html");
//            }
//        };
//    }
}
