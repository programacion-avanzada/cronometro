import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cronometro {

	private static final String ANNONYMOUS = "annonymous";

	private Precision precision;
	private Map<String, List<Long>> valores = new HashMap<String, List<Long>>();

	public Cronometro(Precision precision) {
		this.precision = precision;
	}

	public Cronometro() {
		this(Precision.SEGUNDOS);
	}

	public void clic() {
		clic(ANNONYMOUS);
	}

	public void clic(String key) {
		List<Long> mediciones = valores.get(key);

		if (mediciones == null) {
			mediciones = new LinkedList<Long>();
		}
		mediciones.add(System.nanoTime());
		valores.put(key, mediciones);
	}

	public Resultados getResultado(String key) {
		return procesar(key);
	}

	public Resultados getResultado() {
		return getResultado(ANNONYMOUS);
	}

	private Resultados procesar(String key) {
		return new Resultados(valores.get(key), this.precision);
	}

}
