package AB5;
public class Quicksort {
	
	private Container[] _array;
	private Container _pivot;
	private int _pivotkey;
	private int _count;

	/**
	 * 
	 * @param arr das zu Sortierende Array
	 */
	public void sort(Container[] arr)
	{
		_array = arr;
		_count = 0;
		sort(0,arr.length);
	}
	
	private void sort(int anf, int ende)
	{
		if(ende-anf > 1)
		{
			ermittlePivotRechts(anf,ende);
			for(int i = anf; i < _pivotkey; i++)
			{
					if(_array[i].getKey()> _pivot.getKey())
					{
						_count++;
						swop(i);
						i--;
					}
			}
			for(int i = _pivotkey+1; i < ende;i++)
			{
				if(_array[i].getKey()< _pivot.getKey())
				{
					_count++;
					swopVor(i);
					i--;
				}
			}
			int cut = _pivotkey;
			sort(anf,cut);
			sort(cut+1,ende);
		}
	}
	
	private void swopVor(int index)
	{
		Container obj = _array[index];
		for(;index > _pivotkey;index--)
		{
			_array[index] = _array[index-1];
		}
		_array[_pivotkey] = obj;
		_pivotkey++;
	}
	
	private void swop(int index)
	{
		Container obj = _array[index];
		for(;index < _pivotkey;index++)
		{
			_array[index] = _array[index+1];
		}
		_array[_pivotkey] = obj;
		_pivotkey--;
	}
	
	private void ermittlePivotRechts(int anf, int ende)
	{
		_pivotkey = ende-1;
		_pivot = _array[ende-1];
	}
	
	private void ermittlePivotMedian(int anf, int ende)
	{
		int a = _array[anf].getKey();
		int b = _array[ende-1].getKey();
		int c = _array[(ende-anf)/2+anf].getKey();
		char result;
		if(a < b)
		{
			if(c < a)
				result = 'a';
			else if(c<b)
				result = 'c';
			else
				result = 'b';
		}
		else if(c < b)
			result = 'b';
		else if(c < a)
			result = 'c';
		else
			result = 'a';
		Container ergebnis;
		switch(result){
		case 'a': ergebnis =  _array[anf]; _pivotkey = anf; break;
		case 'b': ergebnis =  _array[ende-1]; _pivotkey = ende-1; break;
		case 'c': ergebnis = _array[(ende-anf)/2+anf]; 	_pivotkey = (ende-anf)/2+anf; break;
		default : ergebnis = _array[anf]; _pivotkey = 0; break;
		}
		_pivot = ergebnis;
		
	}
	
	private void ermittlePivotRandom(int anf, int ende)
	{
		int num;
		do
		{
			num = (int) (Math.random()*10*_array.length) % ende;
		}while(num < anf || num > ende-1);
		_pivotkey = num;
		_pivot = _array[num];
	}
	
	public int getCount()
	{
		return _count;
	}
	
//	private void sort2(int anf, int ende)
//	{
//		if(ende-anf > 1)
//		{
//			int anf1 = anf;
//			ermittlePivotRechts(anf,ende);
//			swop(_pivotkey,ende-1);
//			_pivotkey = ende-1;
//			for(int i = anf; i < ende-1; i++)
//			{
//					if(_array[_pivotkey-1].getKey()> _pivot.getKey())
//					{
//						swop(_pivotkey,_pivotkey-1);
//						_pivotkey--;
//					}
//					else
//					{
//						swop(anf1,_pivotkey-1);
//						anf1++;
//					};
//			}
//			sort(anf,anf1);
//			sort(anf1+1,ende);
//		}
//	}
//	
//	private void swop2(int a, int b)
//	{
//		if(a != b){
//		Container obj = _array[a];
//		_array[a] = _array[b];
//		_array[b] = obj;
//		}
//	}
}
