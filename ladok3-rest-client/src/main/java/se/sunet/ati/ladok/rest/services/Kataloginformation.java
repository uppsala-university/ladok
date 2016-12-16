package se.sunet.ati.ladok.rest.services;

import se.ladok.schemas.kataloginformation.I18NLista;
import se.ladok.schemas.kataloginformation.Perioder;
import se.ladok.schemas.kataloginformation.SuccessivaFordjupningar;

public interface Kataloginformation extends LadokServiceProperties {
	public I18NLista hamtaOversattningarSvenska();

	public Perioder listaLokalaPerioder();

	public SuccessivaFordjupningar listaSuccessivaFordjupningar();
}
