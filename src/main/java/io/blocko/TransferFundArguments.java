package io.blocko;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.Setter;

public class TransferFundArguments {

  @Getter
  @Setter
  @Parameter(names = {"-h", "--help"}, description = "show help", help = true)
  private boolean help = false;

  @Getter
  @Setter
  @Parameter(names = {"-e", "--endpoint"}, description = "node endpoint (default : http://localhost:3000)")
  private String endpoint;

  @Getter
  @Setter
  @Parameter(names = {"-p", "--private"}, description = "your private key", required = true)
  private String privateKey;

  @Getter
  @Setter
  @Parameter(names = {"-a", "--amount"}, description = "transfer amount", required = true)
  private String amount;

  @Getter
  @Setter
  @Parameter(names = {"-t", "--target"}, description = "target address", required = true)
  private String targetAddress;

}
