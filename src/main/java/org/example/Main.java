import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static java.lang.IO.*;

void main() throws IOException {
    Faker faker = new Faker();
    println("Famous quote by Chuck Norris: " + faker.chuckNorris().fact());
    println("Pokemon selvatico: " + faker.pokemon().name());

    String asciiArt = FigletFont.convertOneLine("perin omosessuale");
    println(asciiArt);

    File dest = new File("qrcode.png");
    File file = QRCode.from("http://federicomaniglio.com")
            .to(ImageType.PNG)
            .file();
    Files.copy(file.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    println("QR CODE GENERATO: " + dest.getAbsolutePath());
}