package AB5;

public class Quicksort {

	/**
	 * Zum zaehlen der Rechenoperationen.
	 */
	private long counter = 0;

	/**
	 * Sortiert eine Liste nach dem Algorithmus Quicksort.
	 * 
	 * @param array Feld
	 * @param links Bereichsgrenze
	 * @param rechts Bereichsgrenze
	 * @param v Pivotsuchverfahren
	 * @throws Exception
	 */
	public void quicksort(Container[] array, int links, int rechts, Pivotsuchverfahren v) throws Exception {

		if (array == null) {
			throw new Exception();
		}
		
		// Abbruch bei weniger als zwei Elementen
		if (links < rechts && rechts >= 0 && links >= 0) {

			// Init
			int[] pq = new int[2];
			int p, q;

			// Sortiere grob in zwei Partitionen
			pq = partitioniere(array, links, rechts, v);
			p = pq[0];
			q = pq[1];

			// sortiere die Partitionen rekursiv
			quicksort(array, links, p, v);
			quicksort(array, q, rechts, v);
		}
	}

	/**
	 * Sortiert grob in zwei Partionen.
	 * 
	 * @param array Feld
	 * @param links Bereichsgrenze
	 * @param rechts Bereichsgrenze
	 * @param v Pivotsuchverfahren
	 * @return Partionsgrenzen
	 */
  private int[] partitioniere(Container[] array, int links, int rechts, Pivotsuchverfahren v) {

	  int[] ji = new int[2];
	  int i = links;
	  int j = rechts;

	  // Pivotelement
	  Container p = pivotauswahl(array, links, rechts, v);

	  while (i <= j) {
		  counter++;
		  // suche Tauschkandidaten von links
		  while (array[i].getKey() < p.getKey()) {
			  counter++;
			  i++;
		  }
		  
		  // suche Tauschkandidaten von rechts
		  while (array[j].getKey() > p.getKey()) {
			  counter++;
			  j--;
		  }
		
		  // tausche, falls noch nicht fertig sortiert
		  if (i <= j) {
			  counter++;
			  Container tmp = array[i];
			  array[i] = array[j];
			  array[j] = tmp;
			  i++;
			  j--;
		  }
	  }

	  ji[0] = j;
	  ji[1] = i;
	  return ji;
  }

/**
   * @param array Feld
   * @param links Bereichgrenze
   * @param rechts Bereichgrenze
   * @param v Pivotsuchverfahren
   * @return pivotelement
   */
  private Container pivotauswahl(Container[] array, int links, int rechts, Pivotsuchverfahren v) {
    Container pivot = null;
    switch (v) {
    case RECHTS:
      pivot = array[rechts];
      break;
    case MEDIAN:
      pivot = median(array[links], array[(links + rechts) / 2], array[rechts]);
      break;
    case ZUFAELLIG:
      pivot = array[(int) (Math.random() * (rechts - links + 1) + links)];
      break;
    default:
      break;
    }
    return pivot;
  }

  	/**
	 * 
	 * @param links Bereichsgrenze
	 * @param mitte Mittelwert im Bereich
	 * @param rechts Bereichsgrenze
	 * @return den Median der drei Werte
	 */
	private Container median(Container links, Container mitte, Container rechts) {
		// Ueberprueft, ob mitte der Median ist
		if (mitte.getKey() > rechts.getKey() ^ mitte.getKey() > links.getKey()) {
			return mitte;
		}

		// Ueberprueft, ob rechts der Median ist
		if (rechts.getKey() > mitte.getKey() ^ rechts.getKey() > links.getKey()) {
			return rechts;
		}
		// sonst muss es links sein
		return links;
	}
	
	
	public long getCounter()
	{
		return counter;
	}

}
