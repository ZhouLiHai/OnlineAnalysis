package BladeExample;

import com.blade.Blade;
import com.blade.mvc.handler.RouteHandler;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

public class ApplicationExample {
	public static void main(String[] args) {
		Blade blade = Blade.me();

		blade.get("/", new RouteHandler() {
			@Override
			public void handle(Request request, Response response) {
				response.html("hello world.");
			}
		});

		// TODO: 怎么api老是变动啊，好好的用不行么？
//		blade.start(ApplicationExample.class);
	}
}