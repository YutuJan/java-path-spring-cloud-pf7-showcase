package gr.codelearn.spring.cloud.showcase.mail.bootstrap;

import gr.codelearn.spring.cloud.showcase.core.base.AbstractLogComponent;
import gr.codelearn.spring.cloud.showcase.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("sample-mail")
@Component
@RequiredArgsConstructor
public class SampleMailRunner extends AbstractLogComponent implements CommandLineRunner {
	private final MailService mailService;

	@Override
	public void run(String... args) throws Exception {
		mailService.sendEmail("username@gmail.com", "First sample subject", "Hello from a sample <b>Spring Boot</b>.");

		mailService.sendEmail("username@gmail.com", "Second sample subject",
							  "<p>Hello from a sample <b>Spring Boot</b>.</p><p>Thank you</p>");
	}
}
