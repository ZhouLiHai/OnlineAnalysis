package main.com.neptune8.juc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;

public class NettyServer {

	public void bind(int port) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.handler(new LoginServerHandler()).childHandler(new ChannelInitializer() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					System.out.println("init channel.");
				}
			});

			ChannelFuture channelFuture = b.bind(port).sync();
			channelFuture.channel().closeFuture().sync();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	private class LoginServerHandler extends ChannelInboundHandlerAdapter {
		@Override
		public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
			System.out.println("channel registered.");
		}

		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			System.out.println("channel active.");
		}

		@Override
		public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
			System.out.println("handler add.");
		}


	}

	public static void main(String[] args) {
		new NettyServer().bind(8080);
	}

}
