package io.blocko;

import static io.blocko.coinstack.Math.convertToSatoshi;

import io.blocko.coinstack.BasicEndpoint;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.exception.CoinStackException;
import java.io.IOException;
import java.util.Optional;

public class SimpleFundTransferer {

  protected static final long FEE = convertToSatoshi("0.0001");

  protected String endpoint = "http://localhost:3000";

  public void transfer(final TransferFundArguments arguments)
      throws IOException, CoinStackException {
    endpoint = Optional.ofNullable(arguments.getEndpoint()).orElse(endpoint);
    this.transfer(arguments.getPrivateKey(), arguments.getTargetAddress(), arguments.getAmount());
  }

  public void transfer(final String privateKey, final String toAddress, final String amountInString)
      throws IOException, CoinStackException {
    final CoinStackClient client = new CoinStackClient(null, null, new BasicEndpoint(endpoint));

    final long amount = io.blocko.coinstack.Math.convertToSatoshi(amountInString);
    TransactionBuilder builder = new TransactionBuilder();
    builder.addOutput(toAddress, amount);
    builder.setFee(FEE);

    String rawSignedTx = client.createSignedTransaction(builder, privateKey);
    client.sendTransaction(rawSignedTx);
  }

}
