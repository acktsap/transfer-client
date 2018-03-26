package io.blocko;

import com.beust.jcommander.JCommander;
import io.blocko.coinstack.exception.CoinStackException;
import java.io.IOException;

public class TransferLauncher {

  public static void main(String[] args) throws IOException, CoinStackException {
    final TransferFundArguments arguments = new TransferFundArguments();
    final JCommander jCommander = JCommander.newBuilder().addObject(arguments).build();
    jCommander.parse(args);
    if (arguments.isHelp()) {
      jCommander.usage();
      return;
    }
    new SimpleFundTransferer().transfer(arguments);
  }

}
