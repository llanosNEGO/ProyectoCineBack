package com.devDJ.cinerma;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.devDJ.cinerma.Entities.*;
import com.devDJ.cinerma.Repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CinermaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinermaApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner loadData(
            ICitiesRepository citiesRepository,
            ICinemasRepository cinemasRepository,
            IRoomsRepository roomRepository,
            IMovieRepository movieRepository,
            IScheduleRepository scheduleRepository) {
        return args -> {
            // Ejemplo para 2 cines
            Cities lima = new Cities();
            lima.setName("Lima");
            citiesRepository.save(lima);

            Cinemas cine1 = new Cinemas();
            cine1.setName("CP Alcazar");
            cine1.setDescription("Cine con tecnología 4DX");
            cine1.setAddress("Av. Santa Cruz 814-816");
            cine1.setUrlImage("https://cdnpe.cineplanet.com.pe/assets/77a68319-ab16-4888-b287-7a8235d6fb52");
            cine1.setHorarios(Arrays.asList("5:00 pm", "8:30 pm"));
            cine1.setDisponible(Arrays.asList("2D", "REGULAR"));
            cine1.setCity(lima);

            Cinemas cine2 = new Cinemas();
            cine2.setName("CP Arequipa Mall Plaza");
            cine2.setDescription("El mejor cine del sur");
            cine2.setAddress("Av. Ejemplo 123");
            cine2.setUrlImage("https://cdnpe.cineplanet.com.pe/assets/92264a76-78f6-44ad-b1c4-291a0f9d87dd");
            cine2.setHorarios(Arrays.asList("4:00 pm", "7:30 pm"));
            cine2.setDisponible(Arrays.asList("3D", "PRIME"));
            cine2.setCity(lima);

            cinemasRepository.saveAll(Arrays.asList(cine1, cine2));

            // Crear una película
            Movie movie1 = new Movie();
            movie1.setTitle("Alas Blancas");
            movie1.setUrl("https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/FilmPosterGraphic/HO00002184");
            movie1.setSinopsis("Sinopsis de Alas Blancas...");
            movie1.setGenre("Drama");
            movie1.setDirector("-");
            movie1.setDurationMovie("2 horas 0 minutos");
            movie1.setAge("+14");
            movie1.setUrlTrailer("https://youtu.be/exEaAyvbQ2c");
            movie1.setIdioma(Arrays.asList("SUBTITULAR", "DOBLADA"));
            movie1.setStatus(Arrays.asList("Cartelera"));
            movie1.setDisponible(Arrays.asList("REGULAR", "2D"));

            Movie movie2 = new Movie();
            movie2.setTitle("Venom: El Ultimo Baile");
            movie2.setUrl("https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/FilmPosterGraphic/HO00002088");
            movie2.setSinopsis("Eddie y Venom están a la fuga...");
            movie2.setGenre("Acción");
            movie2.setDirector("-");
            movie2.setDurationMovie("1 hora 50 minutos");
            movie2.setAge("+14");
            movie2.setUrlTrailer("https://youtu.be/whyT4WCy7ek");
            movie2.setIdioma(Arrays.asList("SUBTITULAR", "DOBLADA"));
            movie2.setStatus(Arrays.asList("Cartelera"));
            movie2.setDisponible(Arrays.asList("REGULAR", "2D"));

            movieRepository.saveAll(Arrays.asList(movie1, movie2));

            System.out.println("Datos de prueba cargados exitosamente.");
        };
    }

    @Bean
    public CommandLineRunner loadDulceria(IDulceriaRepository dulceriaRepository) {
        return args -> {
            Dulceria combo1 = new Dulceria();
            combo1.setTitle("COMBO DOS SALADO + 2M&M OL");
            combo1.setDescription(Arrays.asList(
                    "1 Canchita Gigante (Salada)",
                    "2 Bebidas (32oz)"
            ));
            combo1.setCost(47.0);
            combo1.setCategory("Promocional");
            combo1.setUrlImage("https://cdn.apis.cineplanet.com.pe/CDN/media/entity/get/ItemGraphic/3033?allowPlaceHolder=true");

            dulceriaRepository.save(combo1);
        };
    }

}
