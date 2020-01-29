package system;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.mendix.core.actionmanagement.IActionRegistrator;

@Component(immediate = true)
public class UserActionsRegistrar
{
  @Reference
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(encryption.actions.DecryptString.class);
    registrator.registerUserAction(encryption.actions.EncryptString.class);
    registrator.registerUserAction(encryption.actions.GeneratePGPKeyRing.class);
    registrator.registerUserAction(encryption.actions.PGPDecryptDocument.class);
    registrator.registerUserAction(encryption.actions.PGPEncryptDocument.class);
    registrator.registerUserAction(encryption.actions.ValidatePrivateKeyRing.class);
    registrator.registerUserAction(kafkamodule.actions.GetMessagesFromOffset.class);
    registrator.registerUserAction(kafkamodule.actions.GetPartitionOffsets.class);
    registrator.registerUserAction(kafkamodule.actions.GetPosition.class);
    registrator.registerUserAction(kafkamodule.actions.ListTopics.class);
    registrator.registerUserAction(kafkamodule.actions.SendAsynchronous.class);
    registrator.registerUserAction(kafkamodule.actions.SendSynchronous.class);
    registrator.registerUserAction(kafkamodule.actions.StartConsumer.class);
    registrator.registerUserAction(kafkamodule.actions.StartFilteredProcessor.class);
    registrator.registerUserAction(kafkamodule.actions.StartProcessor.class);
    registrator.registerUserAction(kafkamodule.actions.StartProducer.class);
    registrator.registerUserAction(kafkamodule.actions.StopAll.class);
    registrator.registerUserAction(kafkamodule.actions.StopConsumer.class);
    registrator.registerUserAction(kafkamodule.actions.StopProcessor.class);
    registrator.registerUserAction(kafkamodule.actions.StopProducer.class);
    registrator.registerUserAction(mxmodelreflection.actions.ReplaceToken.class);
    registrator.registerUserAction(mxmodelreflection.actions.SyncObjects.class);
    registrator.registerUserAction(mxmodelreflection.actions.TestThePattern.class);
    registrator.registerUserAction(mxmodelreflection.actions.ValidateTokensInMessage.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
