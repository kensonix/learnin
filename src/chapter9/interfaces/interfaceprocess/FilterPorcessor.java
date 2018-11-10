package chapter9.interfaces.interfaceprocess;

import chapter9.interfaces.filters.BandPass;
import chapter9.interfaces.filters.Filter;
import chapter9.interfaces.filters.HighPass;
import chapter9.interfaces.filters.LowPass;
import chapter9.interfaces.filters.Waveform;

public class FilterPorcessor{
	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(2.0)), w);
		Apply.process(new FilterAdapter(new BandPass(1.0,2.0)), w);
	}
}
class FilterAdapter implements Processor{
	Filter filter;
	public FilterAdapter(Filter filter){
		this.filter = filter;
	}
	@Override
	public String name() {
		return filter.name();
	}
	@Override
	public Object process(Object input) {
		return filter.process((Waveform)input);
	}
}
