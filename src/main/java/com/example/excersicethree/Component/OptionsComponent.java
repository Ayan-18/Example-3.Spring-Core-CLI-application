package com.example.excersicethree.Component;

import com.example.excersicethree.document.Text;
import com.example.excersicethree.configuration.OptionConfig;
import com.example.excersicethree.service.TextService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.cli.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OptionsComponent implements CommandLineRunner {
    private final TextService textService;

    @Override
    public void run(String... args) throws ParseException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(OptionConfig.class);

        Options options = new Options();
        options.addOption(new Option("s", true, "Here must be text"));
        options.addOption(new Option("e", true, "Here must be command"));

        CommandLineParser slp = new DefaultParser();

        try {
            CommandLine cl = slp.parse(options, args);

            Text text = ctx.getBean(Text.class, "3", cl.getOptionValue("s"));

            if (cl.getOptionValue("e").equals("add")) {
                textService.save(text);
            } else if (cl.getOptionValue("e").equals("search")){
                List<Text> textList = textService.search();
                for (Text text1:textList) {
                    System.out.println(text1);
                }
            }
        }
        catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
