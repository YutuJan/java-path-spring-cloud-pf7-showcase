package gr.codelearn.spring.cloud.showcase.app.bootstrap;

import gr.codelearn.spring.cloud.showcase.core.base.AbstractLogComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleServiceCallRunner extends AbstractLogComponent implements CommandLineRunner {
	@Override
	public void run(final String... args) {
	}

}
